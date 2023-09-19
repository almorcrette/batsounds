package services

import cats.instances.list._
import cats.syntax.applicative._
import cats.syntax.applicativeError._
import model.ErrorsOr

import java.net.URL
import java.nio.file.Paths
import javax.sound.sampled.{AudioInputStream, AudioSystem}

class AudioInService {

  def readAudioInputStreamFromFile(filePath: String): ErrorsOr[AudioInputStream] = {
    try {
      val url: URL = Paths.get(filePath).toUri.toURL
      val stream = AudioSystem.getAudioInputStream(url)
      stream.pure[ErrorsOr]
    } catch {
      case e: Throwable => List(e.getMessage).raiseError[ErrorsOr, AudioInputStream]
    }
  }

}

