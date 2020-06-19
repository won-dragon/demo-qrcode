package com.example.myapplication;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.service.RestService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class CreateQR extends AppCompatActivity {

    private ImageView iv;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        iv = (ImageView)findViewById(R.id.qrcode);
        text = "shiuser/010-1234-1234/shi-user@shi-ict.com";

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);

            // Post Action
            new Thread(new Runnable() {
                @Override
                public void run() {
                    execute(text);
                }
            }).start();
        }catch (Exception e){}
    }

        private void execute(String text){
            RestService restService = new RestService();
            restService.postAction("/user-info/users",text);
        }
}
