package com.ciko.guo.activity;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ciko.guo.R;
import com.ciko.guo.base.TitleActivity;
import com.ciko.guo.bean.Order;
import com.ciko.guo.bean.Record;
import com.ciko.guo.http.business.config.ApiServiceImp;
import com.ciko.guo.http.business.viewIInterface.IQryOrderObjectView;
import com.ciko.guo.utils.EmptyUtil;
import com.ciko.guo.utils.TimeUtil;
import com.ciko.guo.utils.ToastUtil;
import com.xw.repo.XEditText;

import java.util.List;

/**
 * 创建时间: 2018/3/19 上午3:18
 * 类描述:
 *
 * @author 木棉
 */
public class CodeSearchActivity extends TitleActivity implements IQryOrderObjectView {


    private TextView rectSearchMyDevice;
    private TextView tvNameDeviceCodeSearch;
    private TextView tvOrderCodeDeviceCodeSearch;

    private XEditText etCodeMyDevice;

    private ImageView ivStatusCodeSearch;

    private LinearLayout llCodeStatusList;
    private LinearLayout viewOrderDetail;

    @Override
    protected int getContentLayoutResId() {
        return R.layout.layout_code_search;
    }

    @Override
    protected String getTitleName() {
        return "单号查看";
    }

    @Override
    protected void initView() {
        super.initView();

        rectSearchMyDevice = findView(R.id.rectSearchMyDevice);
        tvNameDeviceCodeSearch = findView(R.id.tvNameDeviceCodeSearch);
        tvOrderCodeDeviceCodeSearch = findView(R.id.tvOrderCodeDeviceCodeSearch);
        etCodeMyDevice = findView(R.id.etCodeMyDevice);
        ivStatusCodeSearch = findView(R.id.ivStatusCodeSearch);
        llCodeStatusList = findView(R.id.llCodeStatusList);
        viewOrderDetail = findView(R.id.viewOrderDetail);

    }

    @Override
    protected void setListener() {
        rectSearchMyDevice.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        viewOrderDetail.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rectSearchMyDevice:
                String code = etCodeMyDevice.getText().toString();
                if (checkInputContent(code)) {
                    ApiServiceImp.qryOrderObject(this, code);
                }
                break;
        }
    }

    private boolean checkInputContent(String code) {
        if (EmptyUtil.isEmpty(code)) {
            ToastUtil.show("订单号不能为空");
            return false;
        }
        return true;
    }

    @Override
    public void postQryOrderObjectResult(Order order) {
        viewOrderDetail.setVisibility(View.GONE);
        if (order != null) {
            viewOrderDetail.setVisibility(View.VISIBLE);
            llCodeStatusList.removeAllViews();

            tvNameDeviceCodeSearch.setText("设备名称：" + order.getDeviceName());
            tvOrderCodeDeviceCodeSearch.setText("单      号：" + order.getOrderNo());

            List<Record> recordList = order.getRecords();
            if (EmptyUtil.isNotEmpty(recordList)) {
                if (recordList.size() == 1) {
                    View viewOne = initView(recordList.get(0), R.layout.item_order_status_one_code_search);
                    llCodeStatusList.addView(viewOne);
                } else if (recordList.size() == 2) {
                    View viewStart = initView(recordList.get(0), R.layout.item_order_status_start_code_search);
                    llCodeStatusList.addView(viewStart);
                    View viewEnd = initView(recordList.get(1), R.layout.item_order_status_end_code_search);
                    llCodeStatusList.addView(viewEnd);
                } else if (recordList.size() >= 3) {

                    View viewStart = initView(recordList.get(0), R.layout.item_order_status_start_code_search);
                    llCodeStatusList.addView(viewStart);

                    for (int i = 1; i < recordList.size() - 1; i++) {
                        View view = initView(recordList.get(0), R.layout.item_order_status_code_search);
                        llCodeStatusList.addView(view);
                    }

                    View viewEnd = initView(recordList.get(recordList.size() - 1), R.layout.item_order_status_end_code_search);
                    llCodeStatusList.addView(viewEnd);

                }
            }
            ToastUtil.show("查询成功");
        } else {
            ToastUtil.show("没有相关的订单记录");
        }
    }

    @NonNull
    private View initView(Record record, int item_order_status_end_code_search) {
        View viewEnd = LayoutInflater.from(getContext()).inflate(item_order_status_end_code_search, null);

        TextView tvTimeOrderStatus = (TextView) viewEnd.findViewById(R.id.tvTimeOrderStatus);
        TextView tvDateOrderStatus = (TextView) viewEnd.findViewById(R.id.tvDateOrderStatus);
        TextView tvMenoOrderStatus = (TextView) viewEnd.findViewById(R.id.tvMenoOrderStatus);

        String date = TimeUtil.millis2String(record.getCreateTime());
        String[] timeArr = date.split(" ");

        tvTimeOrderStatus.setText(timeArr[1]);
        tvDateOrderStatus.setText(timeArr[0]);

        tvMenoOrderStatus.setText(record.getStateName());

        return viewEnd;
    }
}
