package io.github.maple8192.playsoundlib.sound

class Score {
    val score = mutableMapOf<Int, List<Note>>()

    fun add(time: Int, notes: List<Note>): Score {
        score[time] = notes

        return this
    }
}