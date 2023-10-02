// vite.config.ts
import { defineConfig } from "file:///Users/daiyuang/Projects/Toolkit/node_modules/.pnpm/vite@4.4.9_@types+node@18.18.0_sass@1.32.12/node_modules/vite/dist/node/index.js";
import dtsPlugin from "file:///Users/daiyuang/Projects/Toolkit/node_modules/.pnpm/vite-plugin-dts@3.6.0_typescript@5.2.2_vite@4.4.9/node_modules/vite-plugin-dts/dist/index.mjs";
var vite_config_default = defineConfig({
  plugins: [dtsPlugin()],
  build: {
    sourcemap: true,
    lib: {
      entry: "./src/index.ts",
      name: "request-core",
      fileName: "request-core"
    }
  }
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcudHMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCIvVXNlcnMvZGFpeXVhbmcvUHJvamVjdHMvVG9vbGtpdC9wYWNrYWdlcy9yZXF1ZXN0LWNvcmVcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfZmlsZW5hbWUgPSBcIi9Vc2Vycy9kYWl5dWFuZy9Qcm9qZWN0cy9Ub29sa2l0L3BhY2thZ2VzL3JlcXVlc3QtY29yZS92aXRlLmNvbmZpZy50c1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9pbXBvcnRfbWV0YV91cmwgPSBcImZpbGU6Ly8vVXNlcnMvZGFpeXVhbmcvUHJvamVjdHMvVG9vbGtpdC9wYWNrYWdlcy9yZXF1ZXN0LWNvcmUvdml0ZS5jb25maWcudHNcIjtpbXBvcnQgeyBkZWZpbmVDb25maWcgfSBmcm9tICd2aXRlJztcbmltcG9ydCBkdHNQbHVnaW4gZnJvbSAndml0ZS1wbHVnaW4tZHRzJztcblxuZXhwb3J0IGRlZmF1bHQgZGVmaW5lQ29uZmlnKHtcbiAgcGx1Z2luczogW2R0c1BsdWdpbigpXSxcbiAgYnVpbGQ6IHtcbiAgICBzb3VyY2VtYXA6IHRydWUsXG4gICAgbGliOiB7XG4gICAgICBlbnRyeTogJy4vc3JjL2luZGV4LnRzJyxcbiAgICAgIG5hbWU6ICdyZXF1ZXN0LWNvcmUnLFxuICAgICAgZmlsZU5hbWU6ICdyZXF1ZXN0LWNvcmUnLFxuICAgIH0sXG4gIH0sXG59KTtcbiJdLAogICJtYXBwaW5ncyI6ICI7QUFBb1YsU0FBUyxvQkFBb0I7QUFDalgsT0FBTyxlQUFlO0FBRXRCLElBQU8sc0JBQVEsYUFBYTtBQUFBLEVBQzFCLFNBQVMsQ0FBQyxVQUFVLENBQUM7QUFBQSxFQUNyQixPQUFPO0FBQUEsSUFDTCxXQUFXO0FBQUEsSUFDWCxLQUFLO0FBQUEsTUFDSCxPQUFPO0FBQUEsTUFDUCxNQUFNO0FBQUEsTUFDTixVQUFVO0FBQUEsSUFDWjtBQUFBLEVBQ0Y7QUFDRixDQUFDOyIsCiAgIm5hbWVzIjogW10KfQo=
