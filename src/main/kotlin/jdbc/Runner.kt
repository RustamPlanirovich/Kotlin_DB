package jdbc

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.Statement

fun main() {
    Class.forName("com.mysql.cj.jdbc.Driver")
    val connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC",
        "rustam",
        "Israr@1990"
    )

//    val statement : PreparedStatement = connection.prepareStatement("insert into salespeople (snum, sname, city, comm)" +
//            "values (?,?,?,?)")
//    statement.setInt(1, 1010)
//    statement.setString(2,"Ivanov")
//    statement.setString(3,"Moscow")
//    statement.setInt(4, 50)
//    statement.executeUpdate()

    val statement2 : PreparedStatement = connection.prepareStatement("update salespeople set comm=50 where snum = 1010")
    statement2.executeUpdate()

    val stmt: Statement = connection.createStatement()
    val rs = stmt.executeQuery("select * from salespeople")
    while (rs.next()){
        val string = "${rs.getInt(1)} ${rs.getString(2)} ${rs.getString(3)} ${rs.getInt(4)}"
        println(string)
    }
}