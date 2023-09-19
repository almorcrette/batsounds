package services

import cats.instances.list._
import cats.syntax.applicative._
import cats.syntax.applicativeError._
import model.{Audio, ErrorsOr}

import java.net.URL
import java.nio.file.Paths
import javax.sound.sampled.{AudioInputStream, AudioSystem}

class AudioInService {

  def readAudioFromFile(filePath: String): ErrorsOr[Audio] = {
    try {
      val url: URL = Paths.get(filePath).toUri.toURL
      val stream = AudioSystem.getAudioInputStream(url)
      val format = AudioSystem
        .getAudioFileFormat(url)
        .getFormat
      val audio = Audio(stream, format)
      audio.pure[ErrorsOr]
    } catch {
      case e: Throwable => List(e.getMessage).raiseError[ErrorsOr, Audio]
    }
  }

}

