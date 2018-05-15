package com.example.vitaliy.ppctfmp3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public static final String EXTRA_MESSAGE = "com.example.vitaliy.ppctfmp3.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data_in, container, false);

        Button okButton = view.findViewById(R.id.button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputMessage();
            }
        });

        Button openButton = view.findViewById(R.id.button2);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFile();
            }
        });

        Button clearButton = view.findViewById(R.id.button3);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFile();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String str);
    }

    private void outputMessage() {
        View view = getView();
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        CheckBox checkBox1 = view.findViewById(R.id.checkBox);
        CheckBox checkBox2 = view.findViewById(R.id.checkBox2);

        String enteredText = "result:\n";
        TextView checkedButtonText = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        enteredText += checkedButtonText.getText() + "\n";

        if (checkBox1.isChecked()){
            enteredText += checkBox1.getText() + "\n";
        }
        if (checkBox2.isChecked()){
            enteredText += checkBox2.getText() + "\n";
        }
        mListener.onFragmentInteraction(enteredText);

        saveText(enteredText);
    }

    private void saveText(String text) {
        FileOutputStream fos = null;
        try {
            fos = getActivity().openFileOutput("content.txt", Context.MODE_APPEND);
            fos.write(text.getBytes());
            fos.write("\n".getBytes());
            Toast.makeText(getActivity(), "Data is written to file", Toast.LENGTH_SHORT).show();
        } catch(IOException ex) {
            Toast.makeText(getActivity(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if(fos != null)
                    fos.close();
            }
            catch(IOException ex){
                Toast.makeText(getActivity(), ex.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openFile() {
        FileInputStream fin = null;
        String fileContent = null;

        try {
            fin = getActivity().openFileInput("content.txt");
            if (fin.available() > 0) {
                byte[] bytes = new byte[fin.available()];
                fin.read(bytes);
                fileContent = new String(bytes);
            } else {
                Toast.makeText(getActivity(), "There is no data in file", Toast.LENGTH_SHORT).show();
            }
        }
        catch(IOException ex) {
            Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
                Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        if (fileContent != null) {
            Intent intent = new Intent(getActivity(), FileActivity.class);
            intent.putExtra(EXTRA_MESSAGE, fileContent);
            startActivity(intent);
        }
    }

    private void clearFile() {
        if (getActivity().deleteFile("content.txt")) {
            Toast.makeText(getActivity(), "File deleted", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "There is no such file", Toast.LENGTH_SHORT).show();
        }
    }
}
