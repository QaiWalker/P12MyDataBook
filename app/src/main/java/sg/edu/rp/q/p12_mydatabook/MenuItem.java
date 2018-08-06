package sg.edu.rp.q.p12_mydatabook;

import android.widget.ImageView;

public class MenuItem {
    private String menuName;
    private int imageMenu;

    public MenuItem(String menuName, int imageMenu) {
        this.menuName = menuName;
        this.imageMenu = imageMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getImageMenu() {
        return imageMenu;
    }

    public void setImageMenu(int imageMenu) {
        this.imageMenu = imageMenu;
    }
}
