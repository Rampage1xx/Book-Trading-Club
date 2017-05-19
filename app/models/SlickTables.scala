import slick.driver.MySQLDriver.api._
import java.sql.Timestamp

import slick.profile.SqlProfile.ColumnOption.SqlType


val db = Database.forConfig("db")



class Users(tag: Tag) extends Table[(Int, String, String, Timestamp, Timestamp)](tag, "USERS") {
  def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, SqlType("UUID"))

  def name: Rep[String] = column[String]("USER_NAME")

  def password: Rep[String] = column[String]("PASSWORD")

  def created: Rep[Timestamp] = column[Timestamp]("CREATED_AT", SqlType("timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"))

  def updated: Rep[Timestamp] = column[Timestamp]("UPDATED_AT", SqlType("timestamp not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP"))

  def * = (id, name, password, created, updated)
}


class Books(tag:Tag) extends Table [(Int, String, String)](tag, "BOOKS") {
  def id: Rep[Int] = column[Int]("ID", O.PrimaryKey, SqlType("UUID"))

  def title: Rep[String] =  column[String]("BOOK_TITLE")

  def description: Rep[String] = column[String]("BOOK_DESCRIPTION")



  def * = (id, title, description)
}
