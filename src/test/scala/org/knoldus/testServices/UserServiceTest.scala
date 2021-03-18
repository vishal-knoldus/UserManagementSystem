package org.knoldus.testServices

import org.knoldus.Database.UserRepo
import org.knoldus.model.{Type, User}
import org.knoldus.services.UserService
import org.mockito.Mockito.{mock, when}
import org.scalatest.flatspec.AsyncFlatSpec

class UserServiceTest extends AsyncFlatSpec {
  val mockedUserRepo:UserRepo = mock(classOf[UserRepo])
  val userService = new UserService(mockedUserRepo)
  val user1:User = User(java.util.UUID.randomUUID(),"Vishal",Type.Admin)
  val user:User = User(java.util.UUID.randomUUID(),"Ayush",Type.Admin)
  val updateUser:User = User(java.util.UUID.randomUUID(),"abhay",Type.Customer)

  it should "Create a new user in Database" in{
    when(mockedUserRepo.createUser(user)) thenReturn true
    val result = userService.createUser(user)
    assert(result)
  }
  it should "delete user1 from the database" in{
    when(mockedUserRepo.deleteUser(user1)) thenReturn true
    val result = userService.deleteUser(user1)
    assert(result)
  }
  it should " Update user to updateUser" in{
    when(mockedUserRepo.updateUser(user,updateUser)) thenReturn true
    val result = userService.updateUser(user,updateUser)
    assert(result)
  }
  it should "list of all user" in{
    when(mockedUserRepo.getAllUser) thenReturn List(user)
    val result:List[User] = userService.getAllUser
    assert(result.nonEmpty)
  }
}
