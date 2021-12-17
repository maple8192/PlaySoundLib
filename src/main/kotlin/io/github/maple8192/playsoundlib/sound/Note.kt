package io.github.maple8192.playsoundlib.sound

import org.bukkit.Sound

data class Note(val sound: Sound, val volume: Float = 1.0f, val pitch: Float = 1.0f)