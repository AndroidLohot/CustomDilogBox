package com.example.customdialogbox;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    private EditText edFirstName,edLastName;
    private ExammpleDialogListner listner;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);

        builder.setView(view)
                .setTitle("Login")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String fn=edFirstName.getText().toString();
                        String ln=edLastName.getText().toString();

                        listner.applyText(fn,ln);

                    }
                });

        edFirstName=(EditText) view.findViewById(R.id.edFirstName);
        edLastName=(EditText) view.findViewById(R.id.edLastName);;

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        try {
            listner=(ExammpleDialogListner)context;

        }catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+"most implements ExammpleDialogListner");
        }

    }

    interface ExammpleDialogListner
    {
        void applyText(String fName,String lName);
    }
}
