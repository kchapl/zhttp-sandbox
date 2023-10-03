package sandbox.domain

sealed trait DomainError

final case class RepositoryError(cause: Throwable) extends DomainError { val message: String = cause.getMessage }
final case class ValidationError(message: String)  extends DomainError
case object NotFoundError                          extends DomainError { val message = "NotFoundError"          }
