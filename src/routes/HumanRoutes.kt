package com.example.routes

import com.example.models.Human
import com.example.repository.human.HumanRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlin.random.Random

fun Route.humanRoute(humanRepository: HumanRepository) {

    route("/allUsers") {
        get {
            val users = humanRepository.readAllHumans()
            call.respond(users)
        }
    }

    route("/addUser") {
        get {

            val human = Human(
                name = listOf("Vasili", "Aleksey", "Ivan", "Viktor").shuffled().first(),
                age = Random.nextInt(10, 60),
                weight = Random.nextInt(50, 120),
                height = Random.nextInt(155, 205),
                isMale = Random.nextBoolean()
            )

            val id = humanRepository.addHuman(human)

            val code = if (id.value != -1) HttpStatusCode.OK else HttpStatusCode.InternalServerError

            call.respond(code, human)
        }
    }
}
