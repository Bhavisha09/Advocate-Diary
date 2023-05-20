package com.example.advocatediary;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
public class DetailActivity extends AppCompatActivity {
    TextView detailcaseNo, detailclientName,detailoppName,detailcaseType,detailfilingDate,detailjudgeName,detailareaCase,detailchargeAmount;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailcaseNo = findViewById(R.id.detailcaseNo);
        detailImage = findViewById(R.id.detailImage);
        detailclientName = findViewById(R.id.detailclientName);
        detailoppName = findViewById(R.id.detailoppName);
        detailcaseType = findViewById(R.id.detailcaseType);
        detailfilingDate = findViewById(R.id.detailfilingDate);
        detailjudgeName = findViewById(R.id.detaiLjudgeName);
        detailareaCase = findViewById(R.id.detailArea);
        detailchargeAmount = findViewById(R.id.detailCharge);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailcaseNo.setText(bundle.getString("Case No"));
            detailcaseType.setText(bundle.getString("Case Type"));
            detailclientName.setText(bundle.getString("Client Name"));
            detailoppName.setText(bundle.getString("Opponent Name"));
            detailfilingDate.setText(bundle.getString("Filing Date"));
            detailcaseType.setText(bundle.getString("Case Type"));
            detailjudgeName.setText(bundle.getString("Judge Name"));
            detailareaCase.setText(bundle.getString("Area"));
            detailchargeAmount.setText(bundle.getString("Charge"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Advocate Journal");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("CaseNo", detailcaseNo.getText().toString())
                        .putExtra("ClientName", detailclientName.getText().toString())
                        .putExtra("OpponentName", detailoppName.getText().toString())
                        .putExtra("FilingDate", detailfilingDate.getText().toString())
                        .putExtra("CaseType", detailcaseType.getText().toString())
                        .putExtra("JudgeName", detailjudgeName.getText().toString())
                        .putExtra("Area", detailareaCase.getText().toString())
                        .putExtra("Charge", detailchargeAmount.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
    }
}