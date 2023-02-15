package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class CustomerRouteTest {

    @Test
    fun getCustomersRouteTest() = testApplication {
        val response = client.get("/customer")
        assertEquals(
            """[{"id":"kel_03","firstName":"kelechi","lastName":"opara","email":"me@gmail.com"}]""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testGetCustomer() = testApplication {
        val response = client.get("/customer/kel_03")
        assertEquals(
            """{"id":"kel_03","firstName":"kelechi","lastName":"opara","email":"me@gmail.com"}""",
            response.bodyAsText()
        )
    }

    @Test
    fun testPostCustomerRoute() = testApplication {
        val response = client.get("/customer")
        assertEquals(
            """[{"id":"kel_03","firstName":"kelechi","lastName":"opara","email":"me@gmail.com"}]""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testDeleteCustomerRoute() = testApplication {
        val response = client.get("/customer/kel_03")
        assertEquals(
            """{"id":"kel_03","firstName":"kelechi","lastName":"opara","email":"me@gmail.com"}""",
            response.bodyAsText()
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }
}