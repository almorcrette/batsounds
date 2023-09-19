package model

import cats.data.Validated

type ErrorsOr[T] = Validated[List[String], T]

