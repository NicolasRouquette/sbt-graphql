import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder
import sangria.macros._
import types._
object InputVariables {
  object InputVariables extends GraphQLQuery {
    val document: sangria.ast.Document = graphql"""query InputVariables($$humanId: String!) {
  human(id: $$humanId) {
    name
    homePlanet
  }
}"""
    case class Variables(humanId: String)
    case class Data(human: Option[Human])
    object Data { implicit val jsonDecoder: Decoder[Data] = deriveDecoder[Data] }
    case class Human(name: Option[String], homePlanet: Option[String])
    object Human { implicit val jsonDecoder: Decoder[Human] = deriveDecoder[Human] }
  }
}
