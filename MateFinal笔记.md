# 项目初始化

![1710471022378](C:\Users\Lenovo\AppData\Roaming\Typora\typora-user-images\1710471022378.png)



```
import vue from '@vitejs/plugin-vue';
import Components from 'unplugin-vue-components/vite';
import { VantResolver } from '@vant/auto-import-resolver';

export default {
  plugins: [
    vue
    Components({
      resolvers: [VantResolver()],
    }),
  ],
};
```

