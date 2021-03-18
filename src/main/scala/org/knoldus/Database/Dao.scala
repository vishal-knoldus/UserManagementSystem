package org.knoldus.Database

import org.knoldus.model.User

import java.util.UUID

trait Dao[T]{
  def createUser(entity:T):Boolean

  def getUserById(id:UUID):T

  def updateUser(oldUser:User,updatedUser:User):Boolean

  def deleteUser(user:User):Boolean

  def getAllUser:List[T]
}