package com.example

import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class OrderRouteTest {
    @Test
    fun listOrderRouteTest() = testApplication {
        val response = client.get("/order")
        assertEquals(
            """[{"number":"2020-09-04","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.3},{"item":"Cheesecake","amount":1,"price":3.75}]},{"number":"2021-09-04","contents":[{"item":"Cheeseburger","amount":1,"price":8.5},{"item":"Water","amount":2,"price":1.5},{"item":"Coke","amount":2,"price":1.76},{"item":"Ice Cream","amount":1,"price":2.35}]}]""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testGetOrder() = testApplication {
        val response = client.get("/order/2020-09-04")
        assertEquals(
            """{"number":"2020-09-04","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.3},{"item":"Cheesecake","amount":1,"price":3.75}]}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testTotalOrderRoute()  = testApplication {
        val response = client.get("/order/2020-09-04/total")
        assertEquals("23.15", response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }
}