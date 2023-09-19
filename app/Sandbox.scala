import java.io.File
import java.net.URL
import java.nio.file.Paths
import javax.sound.sampled.{AudioFileFormat, AudioFormat, AudioInputStream, AudioSystem}

object PlayInput extends App {

  val url: URL = Paths.get("/Users/almorcrette/Documents/coding/batsounds/docs/test-wav-file.wav").toUri.toURL

  private val audioIn = AudioSystem.getAudioInputStream(url)
  private val clip = AudioSystem.getClip

  clip.open(audioIn)
  clip.start()

  Thread.sleep(15000)

}

object TrimAudio extends App {

  val startSecond = 0
  val secondsToCopy = 5.5
  val destinationFileName = "/Users/almorcrette/Documents/coding/batsounds/docs/output.wav"

  val url: URL = Paths.get("/Users/almorcrette/Documents/coding/batsounds/docs/test-wav-file.wav").toUri.toURL

  val fileFormat: AudioFileFormat = AudioSystem.getAudioFileFormat(url)
  val format: AudioFormat = fileFormat.getFormat
  val inputStream: AudioInputStream = AudioSystem.getAudioInputStream(url)
  val bytesPerSecond: Int = (format.getFrameSize * format.getFrameRate).toInt
  inputStream.skip(startSecond * bytesPerSecond)
  val framesOfAudioToCopy: Long = (secondsToCopy * format.getFrameRate).toLong
  val shortenedStream = new AudioInputStream(inputStream, format, framesOfAudioToCopy)
  val destinationFile = new File(destinationFileName)
  AudioSystem.write(shortenedStream, fileFormat.getType, destinationFile)

}

object PlayOutput extends App {

  val url: URL = Paths.get("/Users/almorcrette/Documents/coding/batsounds/docs/output.wav").toUri.toURL

  private val audioIn = AudioSystem.getAudioInputStream(url)
  private val clip = AudioSystem.getClip

  clip.open(audioIn)
  clip.start()

  Thread.sleep(15000)

}
