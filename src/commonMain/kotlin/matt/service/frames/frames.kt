package matt.service.frames

import matt.model.data.file.FilePath
import matt.service.MattService

interface MFrameGrabber : MattService {
    fun extractVideoFrames(
        video: FilePath,
        outputFolder: FilePath,
        framesToExtract: List<Int>
    )
}