package matt.service.frames

import matt.lang.model.file.AnyResolvableFilePath
import matt.service.MattService

interface MFrameGrabber : MattService {
    fun extractVideoFrames(
        video: AnyResolvableFilePath,
        outputFolder: AnyResolvableFilePath,
        framesToExtract: List<Int>
    )
}
