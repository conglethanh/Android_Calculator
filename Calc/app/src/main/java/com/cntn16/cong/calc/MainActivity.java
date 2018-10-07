package com.cntn16.cong.calc;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.support.constraint.solver.widgets.ConstraintWidgetGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declare variables
    Button btnClear;
    TextView tvProcess;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnAdd, btnSub, btnMul, btnDiv, btnDecimal, btnBack, btnCalc, btnNeg,
            btnPercent;


    String processor="";//expression
    String tmp, result;//temp and result
    String operator="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
            initUI();
            Toast.makeText(getApplicationContext(),"Portrait mode", Toast.LENGTH_SHORT).show();
        }
        else if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main);
            initUI();
            Toast.makeText(getApplicationContext(),"Landscape mode",Toast.LENGTH_SHORT).show();
        }

    }

    private void initUI() {
        //assign all variables
        btnClear = (Button)findViewById(R.id.btn_Clear);
        tvProcess=(TextView)findViewById(R.id.tv_userInput);


        tvProcess.setText(processor);

        btn1=(Button)findViewById(R.id.btn_1);
        btn2=(Button)findViewById(R.id.btn_2);
        btn3=(Button)findViewById(R.id.btn_3);
        btn4=(Button)findViewById(R.id.btn_4);
        btn5=(Button)findViewById(R.id.btn_5);
        btn6=(Button)findViewById(R.id.btn_6);
        btn7=(Button)findViewById(R.id.btn_7);
        btn8=(Button)findViewById(R.id.btn_8);
        btn9=(Button)findViewById(R.id.btn_9);
        btn0=(Button)findViewById(R.id.btn_0);

        btnMul= (Button)findViewById(R.id.btn_mul);
        btnDiv= (Button)findViewById(R.id.btn_div);
        btnAdd= (Button)findViewById(R.id.btn_add);
        btnSub= (Button)findViewById(R.id.btn_sub);

        btnDecimal=(Button)findViewById(R.id.btn_dot);
        btnBack= (Button)findViewById(R.id.btn_Bksp);

        btnCalc=(Button)findViewById(R.id.btn_calc);
        btnNeg=(Button)findViewById(R.id.btn_negative);
        btnPercent=(Button)findViewById(R.id.btn_percent);
        /**********Number buttons on click***********/
        /********************************************/
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvProcess.setText("");
                operator="";
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum("0");
            }
        });

        /******Operator/Function buttons on click********/
        /***********************************************/
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickOperator("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickOperator("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickOperator("x");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickOperator("/");
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processWhenClickNum(".");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor=tvProcess.getText().toString();
                if (processor.length()>0) {
                    processor = processor.substring(0, processor.length() - 1);
                    tvProcess.setText(processor);
                }
            }
        });


        /*******Calc button click listener*******/
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor = tvProcess.getText().toString();
                onClickCalc();
            }
        });

        btnNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor=tvProcess.getText().toString();
                tvProcess.setText("");
                getNeg(processor);
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processor=tvProcess.getText().toString();
                tvProcess.setText("");
                getPercent(processor);
            }
        });
    }

    private void getPercent(String processor) {
        if (processor.length()>0&& processor != "+"&& processor != "-"&& processor != "x"&& processor != "/")
        {
            float num =Float.valueOf(processor);
            num=num/100;
            tvProcess.setText(String.valueOf(num));
        }
    }


    private void getNeg(String processor) {
        if (processor.length()>0&& processor != "+"&& processor != "-"&& processor != "x"&& processor != "/")
        {
            float num =Float.valueOf(processor);
            num=-num;
            tvProcess.setText(String.valueOf(num));
        }
    }

    private void onClickCalc() {
        if (operator=="")
            tvProcess.setText(processor);
        else{
            try{
                float num1=Float.valueOf(tmp);
                float num2=Float.valueOf(processor);
                float res=0;
                switch (operator)
                {
                    case "+":
                        res=num1+num2;
                        break;
                    case "-":
                        res=num1-num2;
                        break;
                    case "x":
                        res=num1*num2;
                        break;
                    case "/":
                        res=num1/num2;
                        break;
                }

                result=String.valueOf(res);
                tvProcess.setText(result);
            }catch (Exception e) {
                tvProcess.setText("Math Error");
                e.printStackTrace();
            }
        }
    }

    private void processWhenClickOperator(String s) {
        tmp=tvProcess.getText().toString();
        operator=s;
       tvProcess.setText("");

    }

    private void processWhenClickNum(String s) {
        processor=tvProcess.getText().toString();
        processor=processor+s;
        tvProcess.setText(processor);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation==Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
            initUI();
            Toast.makeText(getApplicationContext(),"Portrait mode", Toast.LENGTH_SHORT).show();
        }
        else if (newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main);
            initUI();
            Toast.makeText(getApplicationContext(),"Landscape mode",Toast.LENGTH_SHORT).show();
        }
    }
}
