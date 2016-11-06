package ru.tulupov.alex.medalmanah;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by tulup on 06.11.2016.
 */

public class MyDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    protected DatePickerListener listener;
    protected String type;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        type = getTag();

        DatePickerDialog dialog;
        if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.LOLLIPOP) {
            dialog =  new DatePickerDialog(getActivity(), R.style.MyDatePickerDialogTheme ,this, year, month, day);
        } else {
            dialog =  new DatePickerDialog(getActivity() ,this, year, month, day);
        }

        return dialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        listener.onDatePicked(calendar, this.type);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (DatePickerListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement " + DatePickerListener.class.getName());
        }

    }



    public interface DatePickerListener {
        void onDatePicked(Calendar date, String type);
    }
}