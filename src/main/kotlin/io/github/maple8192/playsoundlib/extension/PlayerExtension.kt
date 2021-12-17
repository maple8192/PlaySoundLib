package io.github.maple8192.playsoundlib.extension

import io.github.maple8192.playsoundlib.sound.Score
import io.github.maple8192.playsoundlib.util.MathUtil
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.scheduler.BukkitRunnable

fun Player.playSoundScore(plugin: Plugin, score: Score) {
    if (score.score.isEmpty()) return

    val times = score.score.keys.toList().sorted()
    val intervals = mutableListOf<Int>()
    for (i in 0 until times.size - 1) {
        intervals.add(times[i + 1] - times[i])
    }
    val intervalGCD = MathUtil.gcd(intervals)

    val finishingTime = times.last()

    var count: Int = 0
    object: BukkitRunnable() {
        override fun run() {
            score.score[count * intervalGCD]?.forEach {
                playSound(location, it.sound, it.volume, it.pitch)
            }

            if (count * intervalGCD >= finishingTime) cancel()

            count++
        }
    }.runTaskTimer(plugin, 0, intervalGCD.toLong())
}