package com.example.badparcel;  
  
import android.app.Activity;  
import android.content.ComponentName;  
import android.content.Intent;  
import android.os.Bundle;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.Toast;  
  
public class MainActivity extends Activity {  
  
    private EditText editTextPackageName;  
    private EditText editTextActivityName;  
    private Button buttonLaunchActivity;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
          
        // Initialize views  
        editTextPackageName = findViewById(R.id.editTextPackageName);  
        editTextActivityName = findViewById(R.id.editTextActivityName);  
        buttonLaunchActivity = findViewById(R.id.buttonLaunchActivity);  
          
        // Set click listener for the button  
        buttonLaunchActivity.setOnClickListener(v -> launchActivity());  
    }  
      
    private void launchActivity() {  
        // Get user input  
        String packageName = editTextPackageName.getText().toString().trim();  
        String activityName = editTextActivityName.getText().toString().trim();  
          
        // Validate input  
        if (packageName.isEmpty() || activityName.isEmpty()) {  
            Toast.makeText(this, "Please enter both package name and activity name", Toast.LENGTH_SHORT).show();  
            return;  
        }  
          
        try {  
            // Create Intent and ComponentName similar to existing implementation  
            Intent intent = new Intent();  
            intent.setComponent(new ComponentName(packageName, activityName));  
            intent.setAction(Intent.ACTION_RUN);  
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
              
            // Optional: Add extra data like in the original implementation  
            String[] authTypes = {getPackageName()};  
            intent.putExtra("account_types", authTypes);  
              
            // Launch the activity  
            startActivity(intent);  
        } catch (Exception e) {  
            Toast.makeText(this, "Failed to launch activity: " + e.getMessage(), Toast.LENGTH_LONG).show();  
        }  
    }  
}
