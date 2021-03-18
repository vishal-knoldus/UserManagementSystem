package org.knoldus.bootstrap
import org.knoldus.Database.UserRepo
import org.knoldus.model.{Type, User}
import org.knoldus.services.UserService

object MainClass{
  def main(args: Array[String]): Unit = {
    val repoInstance = new UserRepo
    val userInstance = new UserService(repoInstance)
    val Admin1 = User(java.util.UUID.randomUUID(),"Vishal", Type.Admin)
    val Customer1 = User(java.util.UUID.randomUUID(),"Abhay",Type.Customer)
    val Admin2 = User(java.util.UUID.randomUUID(),"Nehal", Type.Admin)
    val Customer2 = User(java.util.UUID.randomUUID(),"Abhay",Type.Customer)
    val updatedCustomer2 = User(java.util.UUID.randomUUID(),"Abhay",Type.Admin)
    //Creating User
    userInstance.createUser(Admin1)
    userInstance.createUser(Customer1)
    userInstance.createUser(Admin2)
    userInstance.createUser(Customer2)
    println("==================Initial list of created user data=============")
    println("\n" + userInstance.getAllUser + "\n")

    userInstance.deleteUser(Admin1)
    println("===============List of user data after deleting Admin1===========")
    println("\n" + userInstance.getAllUser + "\n")

    userInstance.updateUser(Customer2,updatedCustomer2)
    println("===========List of user data after updating of Customer2=============")
    println("\n" + userInstance.getAllUser + "\n")

  }
}