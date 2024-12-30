<template>
  <div>
    <el-upload
        ref="upload"
        :action="upload.url"
        :headers="upload.headers"
        list-type="picture"
        :multiple="false" :show-file-list="showFileList"
        :file-list="fileList"
        :on-remove="handleRemove"
        :on-success="handleUploadSuccess"
        :on-preview="handlePreview">
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过10MB</div>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="fileList[0].url" alt="">
    </el-dialog>
  </div>
</template>

<script>
import { getToken } from "@/utils/auth";
export default {
    name: 'singleUpload',
    props: {
      value: String
    },
    computed: {
      imageUrl() {
        console.log("imageUrl", this.value)
        return this.value;
      },
      imageName() {
        if (this.value != null && this.value !== '') {
          return this.value.substring(this.value.lastIndexOf("/") + 1);
        } else {
          return null;
        }
      },
      fileList() {
        console.log("fileList", this.value)
        return [{
          name: this.imageName,
          url: this.imageUrl
        }]
      },
      showFileList: {
        get: function () {
          return this.value !== null && this.value !== ''&& this.value!==undefined;
        },
        set: function (newValue) {
        }
      }
    },
    data() {
        return {
            // 用户导入参数
            upload: {
                // 是否显示弹出层（用户导入）
                open: false,
                // 弹出层标题（用户导入）
                title: "",
                // 是否禁用上传
                isUploading: false,
                // 是否更新已经存在的用户数据
                updateSupport: 0,
                // 设置上传的请求头部
                headers: { Authorization: "Bearer " + getToken() },
                // 上传的地址
                url: process.env.VUE_APP_BASE_API + "main/common/upload", // 上传文件服务器地址
            },
            dialogVisible: false
        }
    },
    methods: {
        emitInput(val) {
            this.$emit('input', val)
        },
        handleRemove(file, fileList) {
            this.emitInput('');
        },
        handlePreview(file) {
            this.dialogVisible = true;
        },
        handleUploadSuccess(res, file) {
            console.log("上传成功...")
            this.showFileList = true;
            this.fileList.pop();
            let filePath = res.fileName.replace('/profile', '')
            let fileUrl = "http://localhost:8081/api" + filePath
            this.fileList.push({name: file.name, url: fileUrl });
            console.log("fileUrl:" + this.fileList[0].url)
            this.emitInput(this.fileList[0].url);
        }
    }
}
</script>

<style>

</style>