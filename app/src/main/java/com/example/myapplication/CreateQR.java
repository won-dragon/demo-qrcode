package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


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
