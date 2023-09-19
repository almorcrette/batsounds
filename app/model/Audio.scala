package model

import javax.sound.sampled.{AudioFormat, AudioInputStream}

case class Audio(stream: AudioInputStream, format: AudioFormat)
