/*
 * Copyright ©  2017 by Yulin Liu. All rights reserved. No part of this publication may be reproduced,
 * distributed, or transmitted in any form or by any means, including photocopying, recording, or other electronic
 *  or mechanical methods, without the prior written permission of the publisher, except in the case of brief
 *  quotations embodied in critical reviews and certain other noncommercial uses permitted by copyright law.
 */

package com.lylin.qrtest;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

/**
 * Created by lylin on 6/27/2017.
 */
public class ReadQRCode {
    public static void main(String[] args) {

        try {
            MultiFormatReader reader = new MultiFormatReader();
            File file = new File("G:/Java Workspace/QRcode_testing/out/img.png");
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");

            Result result = reader.decode(binaryBitmap, hints);

            System.out.println("QR Code is: " + result.toString());
            System.out.println("Code format is: " + result.getBarcodeFormat());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
