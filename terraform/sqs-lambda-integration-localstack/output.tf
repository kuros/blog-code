output "test-queue" {
  value = aws_sqs_queue.test-queue.id
}

output "lambda" {
  value = aws_lambda_function.lambda.invoke_arn
}