<template>
  <div>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="140px">
      <el-form-item label="分类名称:" prop="name">
        <el-input v-model="formData.name" placeholder="请输入分类名称" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="上级分类:" prop="parentId">
        <el-select v-model="formData.parentId" placeholder="请选择上级分类" clearable :style="{width: '100%'}">
          <el-option v-for="(item, index) in parentIdOptions" :key="index" :label="item.label"
            :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="数量单位:" prop="productUnit">
        <el-input v-model="formData.productUnit" placeholder="请输入数量单位" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="排序:" prop="sort">
        <el-input v-model="formData.sort" placeholder="请输入排序" clearable :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item label="是否显示:" prop="showStatus">
        <el-radio-group v-model="formData.showStatus" size="medium">
          <el-radio v-for="(item, index) in showStatusOptions" :key="index" :label="item.value"
            :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="是否显示在导航栏:" prop="navStatus">
        <el-radio-group v-model="formData.navStatus" size="medium">
          <el-radio v-for="(item, index) in navStatusOptions" :key="index" :label="item.value"
            :disabled="item.disabled">{{item.label}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="分类图标:" prop="icon">
        <el-upload ref="icon" :file-list="iconfileList" :action="iconAction" :before-upload="iconBeforeUpload"
          list-type="picture" accept="image/*">
          <el-button size="small" type="primary" icon="el-icon-upload">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传不超过 10MB 的image/*文件</div>
        </el-upload>
      </el-form-item>
      <el-form-item label="筛选属性:" prop="keywords">
        <el-cascader v-model="formData.keywords" :options="keywordsOptions" :props="keywordsProps"
          :style="{width: '100%'}" placeholder="请选择筛选属性" clearable></el-cascader>
      </el-form-item>
      <el-form-item label="关键字:" prop="keywords">
        <el-input v-model="formData.keywords" placeholder="请输入关键字" clearable :style="{width: '100%'}">
        </el-input>
      </el-form-item>
      <el-form-item label="分类描述:" prop="description">
        <el-input v-model="formData.description" type="textarea" placeholder="请输入分类描述"
          :autosize="{minRows: 1, maxRows: 2}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { listCategory, getCategory, delCategory, addCategory, updateCategory } from "@/api/info/category";

export default {
  name: "CategoryEdit",
  components: {},
  props: [],
  data() {
    return {
      formData: {
        name: undefined,
        parentId: '',
        productUnit: undefined,
        sort: undefined,
        showStatus: 1,
        navStatus: undefined,
        icon: null,
        keywords: [],
        keywords: undefined,
        description: '',
      },
      rules: {
        name: [{
          required: true,
          message: '请输入分类名称',
          trigger: 'blur'
        }],
        parentId: [],
        productUnit: [],
        sort: [],
        showStatus: [],
        navStatus: [],
        keywords: [],
        keywords: [],
        description: [],
      },
      iconAction: 'https://jsonplaceholder.typicode.com/posts/',
      iconfileList: [],
      parentIdOptions: [{
        "label": "",
        "value": ""
      }],
      showStatusOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      navStatusOptions: [{
        "label": "是",
        "value": 1
      }, {
        "label": "否",
        "value": 0
      }],
      keywordsOptions: [],
      keywordsProps: {
        "multiple": false
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
    iconBeforeUpload(file) {
      let isRightSize = file.size / 1024 / 1024 < 10
      if (!isRightSize) {
        this.$message.error('文件大小超过 10MB')
      }
      let isAccept = new RegExp('image/*').test(file.type)
      if (!isAccept) {
        this.$message.error('应该选择image/*类型的文件')
      }
      return isRightSize && isAccept
    },
    getKeywordsOptions() {
      // TODO 发起请求获取数据
      this.keywordsOptions
    },
  }
}

</script>
<style>
.el-upload__tip {
  line-height: 1.2;
}

</style>
