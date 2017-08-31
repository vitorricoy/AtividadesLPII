/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.lpii.calculadora.util;

import java.nio.ByteBuffer;

/**
 *
 * @author aluno
 */
public class ByteConverter {
    
    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
    
    public static byte[] toByteArray(int value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putInt(value);
        return bytes;
    }

    public static int toInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
    
    public static byte[] toByteArray(char value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putChar(value);
        return bytes;
    }

    public static char toChar(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getChar();
    }
}
