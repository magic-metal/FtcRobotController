package org.firstinspires.ftc.teamcode.eocv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class AryanThresholdingPipelineTest extends OpenCvPipeline {

    @Override
    public Mat processFrame(Mat input) {
        Scalar lower_blue = new Scalar(85, 50, 40);
        Scalar upper_blue = new Scalar(135, 255, 255);

        //Convert RGB to HSV
        Mat hsvMat = new Mat();
        Imgproc.cvtColor(input, hsvMat, Imgproc.COLOR_RGB2HSV);

        //Apply Threshold
        Mat threshold = new Mat();
        Core.inRange(hsvMat, lower_blue, upper_blue, threshold);

        return threshold;
    }
}