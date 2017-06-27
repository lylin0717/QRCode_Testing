/*
 * Copyright ©  2017 by Yulin Liu. All rights reserved. No part of this publication may be reproduced,
 * distributed, or transmitted in any form or by any means, including photocopying, recording, or other electronic
 *  or mechanical methods, without the prior written permission of the publisher, except in the case of brief
 *  quotations embodied in critical reviews and certain other noncommercial uses permitted by copyright law.
 */

package com.lylin.qrtest;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;

import java.nio.file.Path;
import java.util.HashMap;

/**
 * Created by lylin on 6/26/2017.
 */
public class CreateQRCode {

    public static void main(String[] args) {

        // The configuration for result pic:
        int width = 300;
        int height = 300;
        String format = "png";
        String content = "https://www.linkedin.com/in/yulin-liu-459517a5/";

        // The configuration for the QR Code:
        HashMap hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        // It can hold utf-8(Chinese character).
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // The error correction has 4 level: H, L, M, Q.
        hints.put(EncodeHintType.MARGIN, 2);
        // Set the width of margin.

        // Create the QR code:
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            Path path = new File("G:/Java Workspace/QRcode_testing/out/img.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
