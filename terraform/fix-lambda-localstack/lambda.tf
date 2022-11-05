resource "aws_iam_role" "iam_for_lambda_fix" {
  name = "iam_for_lambda_fix"

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

data "archive_file" "lambda_zip" {
  type        = "zip"
  source_file = "./index.js"
  output_path = "lambda.zip"

}

resource "aws_lambda_function" "lambda" {
  filename         = "lambda.zip"
  function_name    = "lambda_fix"
  role             = aws_iam_role.iam_for_lambda_fix.arn
  handler          = "./index.handler"
  source_code_hash = "${filebase64sha256("./index.js")}"
  runtime          = "nodejs16.x"
  timeout = 30

  depends_on = [data.archive_file.lambda_zip]
}

resource "aws_lambda_function_url" "function_url" {

  function_name = aws_lambda_function.lambda.function_name
  authorization_type = "NONE"

}

output "url" {
  value = aws_lambda_function_url.function_url
}