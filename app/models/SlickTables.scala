package models
import slick.jdbc.MySQLProfile.api._
import java.sql.Timestamp
import java.util.UUID
import controllers.Application
import slick.sql.SqlProfile.ColumnOption.SqlType



class Users(tag: Tag) extends Table[(UUID, String, String, Timestamp, Timestamp)](tag, "USERS") {
  def id: Rep[UUID] = column[UUID]("USER_ID", O.PrimaryKey, SqlType("VARCHAR"))

  def name: Rep[String] = column[String]("USER_NAME")

  def password: Rep[String] = column[String]("PASSWORD")

  def created: Rep[Timestamp] = column[Timestamp]("CREATED_AT", SqlType("timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"))

  def updated: Rep[Timestamp] = column[Timestamp]("UPDATED_AT", SqlType("timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"))

  def * = (id, name, password, created, updated)
}


class Books(tag:Tag) extends Table [(UUID, UUID, String, String)](tag, "BOOKS") {
  def userID: Rep[UUID] = column[UUID]("USER_ID")

  def id: Rep[UUID] = column[UUID]("ID", O.PrimaryKey, SqlType("VARCHAR"))

  def title: Rep[String] =  column[String]("BOOK_TITLE")

  def description: Rep[String] = column[String]("BOOK_DESCRIPTION")

  def owner = foreignKey("USER_FK", userID, TableQuery[Users])(_.id)


  def * = (userID, id, title, description)
}

class TablesList extends Application {
  val db: Any = Database.forConfig("db")
  val users: Any = TableQuery[Users]
  val books: Any = TableQuery[Books]


}


