package cv.yyh.com.myblockcanarytest;

import android.app.AlertDialog;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int size = 10;
    private Objects []element = new Objects[size];
    private Button  btn_onclick;
    private final String TAG = "yuyahao";
    Map<String,Object> m =new HashMap<String,Object>();
    private String[] s = new String[1000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* setContentView(R.layout.activity_test);
        btn_onclick = (Button) findViewById(R.id.btn_onclick);
        btn_onclick.setOnClickListener(this);*/
        setContentView(R.layout.activity_demo);
        int i =  100 * 100 * 123 * 1231241235;
        LogUtil.e(TAG,String.valueOf(i));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, DemoFragment.newInstance())
                .commit();

        Button fab = (Button) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTipDialog();
            }
        });
    }

    private void showTipDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tip");
        builder.setMessage(getResources().getString(R.string.hello_world));
        builder.setNegativeButton("ok", null);
        builder.show();
    }
    public void  pop(){
        int i =0;
        int j=1000;
        while(true){
            for(;i<j;i++){
                String  memoryLeak = "hashmap 内存溢出实例";
                m.put(String.valueOf(i), memoryLeak);
                Log.e(TAG,"MainActivity :  "+ i);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_onclick:
                compute();
                break;
        }
    }
    private static double compute() {
        double result = 0;
        for (int i = 0; i < 1000000; ++i) {
            result += Math.acos(Math.cos(i));
            result -= Math.asin(Math.sin(i));
        }
        return result;
    }
 static Vector v = new Vector(10);
  public static void main(String args){
      for (int i = 1; i<100; i++)  {
          Object o = new Object();
          v.add(o);
          o = null;
      }
  }
    public static void main()  {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧","pwd1",25);

        Person p2 = new Person(" 孙悟空","pwd2",26);
        Person p3 = new Person("猪八戒","pwd3",27);
        set.add(p1);  set.add(p2);
                set.add(p3);
        System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!
         p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变
        set.remove(p3); //此时remove不掉，造成内存泄漏
         set.add(p3); //重新添加，居然添加成功
         System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!
          for (Person person : set)  {
              System.out.println(person);
          }
    }

    class A{
        public A(){
            B.getInstance().setA(this);
        }
      //  ....
    }
    //B类采用单例模式
    static class B{
        private A a;
        private static B instance= new B();
        public B(){}
        public static B getInstance(){
            return instance;
        }
        public void setA(A a){
            this.a=a;
        }  //getter...
    }
}
