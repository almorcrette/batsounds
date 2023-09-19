package services

import cats.instances.list._
import cats.syntax.applicative._
import cats.syntax.applicativeError._

import model.{Audio, ErrorsOr}

import javax.sound.sampled.AudioInputStream


class AudioTrimService {

  def trimToFirstFiveSeconds(audio: Audio): ErrorsOr[AudioInputStream] = {
    try {
      val secondsToCopy = 5
      val format = audio.format
      val stream = audio.stream

      val framesOfAudioToCopy: Long = (secondsToCopy * format.getFrameRate).toLong

      val trimmedStream = new AudioInputStream(stream, format, framesOfAudioToCopy)
      trimmedStream.pure[ErrorsOr]
    } catch {
      case e: Throwable => List(e.getMessage).raiseError[ErrorsOr, AudioInputStream]
    }
  }

}
