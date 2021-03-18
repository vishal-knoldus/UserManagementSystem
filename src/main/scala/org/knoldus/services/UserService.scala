package org.knoldus.services

import org.knoldus.Database.UserRepo
import org.knoldus.model.User

import java.util.UUID

class UserService(userRepo: UserRepo){
  def createUser(user:User):Boolean = {
    userRepo.createUser(user)
    true
  }
  def getUserById(id:UUID):User={
  userRepo.getUserById(id)
  }
  def updateUser(oldUser:User,updatedUser:User):Boolean={
  userRepo.updateUser(oldUser,updatedUser)
  }
  def deleteUser(user: User):Boolean={
  userRepo.deleteUser(user)
  }
  def getAllUser:List[User] = userRepo.getAllUser
}