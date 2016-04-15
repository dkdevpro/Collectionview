package com.din.collectionview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;


/**
 * Created by dineshkumar.m on 19/02/16.
 */
public class ListFragment extends Fragment implements CollectionviewCallbacks {

    private static final String TAG = "List Fragment";

    //private static final int GROUP_ID_NORMAL_EDIT_TEXT = 5;
    //private static final int GROUP_ID_HEADER = 9;
    private static final int GROUP_ID_VIEW_PAGER = 10;
    private static final int GROUP_ID_NORMAL_TEXT_WITH_IMAGE = 20;
    private static final int GROUP_ID_TWO_COLUMNS = 30;
    private static final int GROUP_ID_NORMAL_TEXT = 40;
    private static final int GROUP_ID_HORIZONTAL_VIEW = 50;

    private CollectionView mCollectionView = null;

    private ViewPagerAdapter adapter;

    private boolean isAdapter = false;
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_list, container, false);
        mCollectionView = (CollectionView) root.findViewById(R.id.collection_view);
        getActivity().overridePendingTransition(0, 0);

        adapter = new ViewPagerAdapter(getActivity());


        updateListView();

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setContentTopClearance(int clearance) {
        if (mCollectionView != null) {
            mCollectionView.setContentTopClearance(clearance);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void updateListView() {
        Log.d(TAG, "Updating collection view.");

        CollectionView.Inventory inventory = new CollectionView.Inventory();
        CollectionView.InventoryGroup inventoryGroup;

        //View Pager Data
        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_VIEW_PAGER);
        inventoryGroup.addItemWithTag("view pager");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);


        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_NORMAL_TEXT);
        inventoryGroup.addItemWithTag("normal text with butttons");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_NORMAL_TEXT_WITH_IMAGE);
        inventoryGroup.addItemWithTag("normal text with image");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_HORIZONTAL_VIEW);
        inventoryGroup.addItemWithTag("Horizontal View");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_NORMAL_TEXT);
        inventoryGroup.addItemWithTag("normal text with butttons");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_HORIZONTAL_VIEW);
        inventoryGroup.addItemWithTag("Horizontal View");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_NORMAL_TEXT);
        inventoryGroup.addItemWithTag("normal text with butttons");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_HORIZONTAL_VIEW);
        inventoryGroup.addItemWithTag("Horizontal View");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        inventoryGroup = new CollectionView.InventoryGroup
                (GROUP_ID_NORMAL_TEXT);
        inventoryGroup.addItemWithTag("normal text with butttons");
        inventoryGroup.setDisplayCols(1);
        inventory.addGroup(inventoryGroup);

        mCollectionView.setCollectionAdapter(this);
        mCollectionView.updateInventory(inventory, false);
    }


    @Override
    public View newCollectionHeaderView(Context context, int groupId, ViewGroup parent) {
        return LayoutInflater.from(context)
                .inflate(null, parent, false);
    }

    @Override
    public void bindCollectionHeaderView(Context context, View view, final int groupId,
                                         final String headerLabel, Object headerTag) {
    }

    @Override
    public View newCollectionItemView(Context context, int groupId, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // First inflate the card container.
        int containerLayoutId = 0;
        switch (groupId) {
            //case GROUP_ID_NORMAL_EDIT_TEXT:
            //case GROUP_ID_HEADER:
            //    containerLayoutId = R.layout.header_layout;
            //    break;
            case GROUP_ID_VIEW_PAGER:
                containerLayoutId = R.layout.view_pager;
                break;
            case GROUP_ID_NORMAL_TEXT:
                containerLayoutId = R.layout.view_with_text_and_button;
                break;
            case GROUP_ID_NORMAL_TEXT_WITH_IMAGE:
                containerLayoutId = R.layout.view_text_with_image;
                break;
            case GROUP_ID_TWO_COLUMNS:
                //containerLayoutId = R.layout.explore_io_topic_theme_livestream_card_container;
                break;

            case GROUP_ID_HORIZONTAL_VIEW:
                containerLayoutId = R.layout.view_horizontal;
                break;
            default:
                //containerLayoutId = R.layout.explore_io_card_container;
                break;
        }
        View containerView = null;
        if(groupId != GROUP_ID_VIEW_PAGER){
            containerView = (View) inflater.inflate(containerLayoutId, parent, false);
        }else{
            containerView = (View) inflater.inflate(R.layout.view_pager, parent, false);
            ViewPagerViewHolder viewHolder = new ViewPagerViewHolder();
            viewHolder.pager = (ViewPager) containerView.findViewById(R.id.activity_wizard_media_pager);
            containerView.setTag(viewHolder);
            viewHolder.pager.setAdapter(adapter);
            viewHolder.pager.setCurrentItem(0);
            CirclePageIndicator mIndicator  = (CirclePageIndicator)containerView.findViewById(R.id.indicator);
            mIndicator.setViewPager(viewHolder.pager );
        }
        return containerView;
    }

    @Override
    public void bindCollectionItemView(Context context, View view, int groupId,
                                       int indexInGroup, int dataIndex, Object tag) {
        if (GROUP_ID_NORMAL_TEXT_WITH_IMAGE == groupId) {
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText("Description text here");
        }else if (GROUP_ID_NORMAL_TEXT == groupId) {
            TextView title = (TextView) view.findViewById(R.id.description);
            Button btn_End = (Button) view.findViewById(R.id.buttonEnd);
            Button btn_start = (Button) view.findViewById(R.id.buttonStart);
            title.setText(R.string.placeholder_lorem_ipsum);
            btn_End.setText("Button End");
            btn_start.setText("Button Start");
        }else if (GROUP_ID_HORIZONTAL_VIEW == groupId) {
            ViewGroup viewWithChildrenSubItems = (ViewGroup)(view.findViewById(
                    R.id.content_place_holder));
            for (int viewChildIndex = 0 ; viewChildIndex < viewWithChildrenSubItems.getChildCount(); viewChildIndex++) {
                ViewGroup group = (ViewGroup) viewWithChildrenSubItems.getChildAt(viewChildIndex);
                ViewGroup groupView = (ViewGroup) group.getChildAt(1);
                TextView title = (TextView) groupView.getChildAt(0).findViewById(R.id.horizontal_title);
                TextView info   = (TextView) groupView.getChildAt(1).findViewById(R.id.horizontal_info);
                TextView description = (TextView) groupView.getChildAt(2).findViewById(R.id.horizontal_description);
                //childView.getChildAt(1)
                title.setText("Text Title");
                info.setText("Text more info");
                description.setText("Text description");
                Log.d("list","Child  Count : "+viewChildIndex);
            }
        }
    }
    /**
     * Holds pointers to View's children.
     */
    static class ViewPagerViewHolder {
        ViewPager pager;
    }
}
