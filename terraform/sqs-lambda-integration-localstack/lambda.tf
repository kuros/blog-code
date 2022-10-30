resource "aws_iam_role" "iam_for_lambda" {
  name = "iam_for_lambda"

  assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Action": "sts:AssumeRole",
      "Principal": {
        "Service": "lambda.amazonaws.com"
      },
      "Effect": "Allow",
      "Sid": ""
    }
  ]
}
EOF
}

resource "null_resource" "build" {
  triggers = {
    versions = filesha256("./lambda/src/main.ts")
  }

  provisioner "local-exec" {
    command = "/bin/bash ./scripts/build.sh"
  }
}

data "archive_file" "lambda_zip" {
  type        = "zip"
  source_dir = "./lambda"
  output_path = "lambda_function.zip"
  excludes = ["./lambda/src"]

  depends_on = [null_resource.build]
}

resource "aws_lambda_function" "lambda" {
  filename         = "lambda_function.zip"
  function_name    = "helper-lambda"
  role             = aws_iam_role.iam_for_lambda.arn
  handler          = "dist/main.handler"
  source_code_hash = fileexists("lambda_function.zip") ? "${filebase64sha256("lambda_function.zip")}" : "1"
  runtime          = "nodejs16.x"
  environment {
    variables = {
      URL = var.url
    }
  }

  depends_on = [data.archive_file.lambda_zip]
}

