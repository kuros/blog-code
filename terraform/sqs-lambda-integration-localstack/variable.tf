variable "url" {
  type = string
  description = "Url for forwarding the event"
  default = "http://host.docker.internal:3001/lambda-handler"
}