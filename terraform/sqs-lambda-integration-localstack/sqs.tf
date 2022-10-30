
resource "aws_sqs_queue" "test-queue" {
  name = "test-queue"
  visibility_timeout_seconds = 300
}


resource "aws_lambda_event_source_mapping" "test_queue_lambda_mapping" {
  batch_size        = 1
  event_source_arn  = aws_sqs_queue.test-queue.arn
  enabled           = true
  function_name     = aws_lambda_function.lambda.function_name
}
