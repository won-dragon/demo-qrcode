package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.net.URLDecoder;


public class CreateQR extends AppCompatActivity {

    private ImageView iv;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        iv = (ImageView)findViewById(R.id.qrcode);

        Intent intent = getIntent(); /*데이터 수신*/

        String userName = intent.getExtras().getString("userName");

        try{
            userName = new String(userName.getBytes("UTF-8"), "ISO-8859-1");
            Log.i("TEST", "onCreate: " + userName);
        }catch (Exception e){}

        String userHp = intent.getExtras().getString("userHp");
        String userEmail = intent.getExtras().getString("userEmail");

        text = userName + "/" + userHp + "/" + userEmail;

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);

        }catch (Exception e){}
    }


}
