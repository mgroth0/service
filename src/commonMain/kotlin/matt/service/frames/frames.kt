package matt.service.frames

import matt.lang.model.file.FilePath
import matt.service.MattService

interface MFrameGrabber : MattService {
    fun extractVideoFrames(
        video: FilePath,
        outputFolder: FilePath,
        framesToExtract: List<Int>
    )
}