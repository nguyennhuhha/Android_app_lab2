package com.example.applab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.applab2.Adapter.EmployeeAdapter;
import com.example.applab2.Adapter.employee4;
import com.example.applab2.Model.Employee;
import com.example.applab2.Model.EmployeeFulltime;
import com.example.applab2.Model.EmployeeParttime;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvSelection;
    private Button btnSubmit;
    private EditText etext,et_manv,et_tennv,et_id,et_fullname;
    private CheckBox ck_ismanager;
    private RadioGroup radioGroup;
    EmployeeAdapter employeeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main4);
//        assigment4();

//        setContentView(R.layout.activity_main3);
//        assigment3();z

//        setContentView(R.layout.activity_main2);
//        assigment2();

        setContentView(R.layout.activity_main);
        assignment1();

    }

    public void assignment1() {
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        tvSelection = (TextView) findViewById(R.id.tvSelection);
        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //đối số arg2 là vị trí phần tử trong Data Source (arr)
                tvSelection.setText("position :" + arg2 + "; value =" + arr[arg2]);
            }
        });
    }

    public void assigment2() {
        etext = (EditText) findViewById(R.id.etext);
        ListView lvPerson = (ListView) findViewById(R.id.lv_person);
        tvSelection = (TextView) findViewById(R.id.tvSelection);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        ArrayList<String> names = new ArrayList<String>();
        names.add("Teo");
        names.add("Ty");
        names.add("Bin");
        names.add("Bo");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        lvPerson.setAdapter(adapter);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String name= etext.getText().toString();
                //Thêm dữ liệu mới vào arraylist
                names.add(name);
                //Cập nhật dữ liệu mới lên giao diên
                adapter.notifyDataSetChanged();
                etext.setText("");
            }
        });
        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvSelection.setText("position :" + position + "; value =" + names.get(position));
            }
        });
        //6. xử lý sự kiện Long click
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                names.remove(position);
                adapter.notifyDataSetChanged();
                tvSelection.setText("");
                return false;
            }
        });

    }
    public void assigment3() {
        et_manv = (EditText) findViewById(R.id.et_manv);
        et_tennv = (EditText) findViewById(R.id.et_tennv);
        ListView lvNhanvien = (ListView) findViewById(R.id.lv_person);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        // khai báo đối tượng nhân viên
        final Employee[] employee = {null};

        ArrayList<Employee>arrEmployee=new ArrayList<Employee>();
        ArrayAdapter<Employee>adapter=new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,arrEmployee);
        lvNhanvien.setAdapter(adapter);

        //xử lý khi nhấn button submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radId=radioGroup.getCheckedRadioButtonId();
                String id=et_manv.getText()+"";
                String name=et_tennv.getText()+"";
                if(radId==R.id.rabtn_ct)
                {
                    //tạo instance là FullTime
                    employee[0] =new EmployeeFulltime();
                }
                else
                {
                    //Tạo instance là PartTime
                    employee[0] =new EmployeeParttime();
                }
                //FullTime hay PartTime thì cũng là Employee
                //nên có các hàm này là hiển nhiên
                employee[0].setId(id);
                employee[0].setName(name);
                //Đưa employee vào ArrayList
                arrEmployee.add(employee[0]);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
                et_manv.setText("");
                et_tennv.setText("");
                et_manv.requestFocus();
            }
        });

    }

    public void assigment4() {
        et_id = (EditText) findViewById(R.id.et_id);
        et_fullname = (EditText) findViewById(R.id.et_fullname);
        ListView lvEmployee = (ListView) findViewById(R.id.lv_person);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        ck_ismanager = (CheckBox) findViewById(R.id.ismanager);

        ArrayList<employee4> listEmployee=new ArrayList<employee4>();
        employeeAdapter =new EmployeeAdapter(this, R.layout.item_employee,listEmployee);
        lvEmployee.setAdapter(employeeAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ismanager = false;
                String id=et_id.getText()+"";
                String name=et_fullname.getText()+"";
                if(ck_ismanager.isChecked())
                {
                    ismanager = true;
                }
                employee4 em = new employee4();
                em.setId(id);
                em.setFullName(name);
                em.setManager(ismanager);
                //Đưa employee vào ArrayList
                listEmployee.add(em);
                //Cập nhập giao diện
                employeeAdapter.notifyDataSetChanged();
                et_id.setText("");
                et_fullname.setText("");
                et_id.requestFocus();
                ck_ismanager.setChecked(false);
            }
        });
    }
}