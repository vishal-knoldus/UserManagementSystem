package org.knoldus.testDatabase

import org.knoldus.Database.UserRepo
import org.knoldus.model.{Type, User}
import org.scalatest.flatspec.AnyFlatSpec

import java.util.UUID

class UserRepoTest extends AnyFlatSpec{
  val userRepo = new UserRepo
  val user:User = User(java.util.UUID.randomUUID(),"vishal",Type.Admin)
  val updateUser:User = User(java.util.UUID.randomUUID(),"Abhay",Type.Customer)
  val user1:User = User(java.util.UUID.randomUUID(),"Neha",Type.Customer)
  it should "Create a new User" in {
    val result:Boolean = userRepo.createUser(user)
    assert(result)
  }

  it should "Update the user" in {
    val result:Boolean = userRepo.updateUser(user,updateUser)
    assert(result)
  }

  it should "Delete user" in {
    val result:Boolean = userRepo.deleteUser(updateUser)
    assert(result)
  }

  it should "return the listBuffer that contains all the user" in {
    val result:List[User] = userRepo.getAllUser
    assert(result.isEmpty)
  }

  it should "return user by ID" in {
    val userId:UUID = user1.id
    val result = userRepo.getUserById(userId)
    assert(result != user1)
  }
}
