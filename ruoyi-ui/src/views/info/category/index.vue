<template>
  <div class="app-container">
    <!-- <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="属性数量" prop="attributeCount">
        <el-input
          v-model="queryParams.attributeCount"
          placeholder="请输入属性数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="参数数量" prop="paramCount">
        <el-input
          v-model="queryParams.paramCount"
          placeholder="请输入参数数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form> -->
    <el-card class="box-card" body-style="padding:20px">
      <div>
        <i class="el-icon-tickets card-icon"></i>
        <span>数据列表</span>
        <el-button
          style="float: right;"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['info:category:add']"
        >添加</el-button>
      </div>
    </el-card>
    <!-- <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['info:category:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['info:category:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['info:category:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['info:category:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row> -->

    <el-table class="box-table" v-loading="loading" :data="categoryList" :border=true @selection-change="handleSelectionChange">
      <el-table-column label="编号" align="center" prop="id" />
      <el-table-column label="分类名称" align="center" prop="name" />
      <el-table-column label="级别" align="center" prop="level" :formatter="levelFormatter"/>
      <el-table-column label="商品数量" align="center" prop="productCount" />
      <el-table-column label="数量单位" align="center" prop="productUnit" />
      <el-table-column label="导航栏" align="center">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.navStatus"
            :active-value="1"
            :inactive-value="0"
            @change=handleNavStatusChange(scope.row)
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="是否显示" align="center" prop="showStatus">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.showStatus"
            :active-value="1"
            :inactive-value="0"
            @change=handleShowStatusChange(scope.row)
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="排序" align="center" prop="sort" />
      <el-table-column label="设置" align="center" width="120">
        <template slot-scope="scope">
        <el-button
            size="mini"
            @click="handerChildrenClick(scope.row)"
            :disabled="scope.row.level | disableNextLevel"
            >查看下级</el-button>
        <!-- <el-button
            size="mini"
            >转移商品</el-button> -->
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="200">
        <template slot-scope="scope">
          <el-button
            size="mini"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['info:category:edit']"
          >编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['info:category:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改商品属性分类对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="属性数量" prop="attributeCount">
          <el-input v-model="form.attributeCount" placeholder="请输入属性数量" />
        </el-form-item>
        <el-form-item label="参数数量" prop="paramCount">
          <el-input v-model="form.paramCount" placeholder="请输入参数数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCategory, getCategory, delCategory, addCategory, updateCategory } from "@/api/info/category";

export default {
  name: "Category",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      // 商品属性分类表格数据
      categoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        attributeCount: null,
        paramCount: null,
        parentId:0
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  watch: {
    $route(route) {
      this.resetParentId();
      this.getList();
    }
  },
  methods: {
    resetParentId(){
        this.queryParams.pageNum = 1;
        if (this.$route.query.parentId != null) {
          this.queryParams.parentId = this.$route.query.parentId;
        } else {
          this.queryParams.parentId = 0;
        }
      },
    /** 查询商品属性分类列表 */
    getList() {
      this.loading = true;
      listCategory(this.queryParams).then(response => {
        this.categoryList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        attributeCount: null,
        paramCount: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品属性分类";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.$router.push({ path: "/info/category/edit", query: {id:row.id} });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCategory(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCategory(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除商品属性分类编号为"' + ids + '"的数据项？').then(function() {
        return delCategory(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('info/category/export', {
        ...this.queryParams
      }, `category_${new Date().getTime()}.xlsx`)
    },
    levelFormatter(row,column){
      let level = row.level
      if(level ===0){
        return '一级'
      }
      return '二级'
    },
    handleNavStatusChange(row){
      let req  = {'id':row.id,'navStatus':row.navStatus}
      updateCategory(req).then(response => {
        this.$modal.msgSuccess("修改成功");
        this.getList();
      });
    },
    handleShowStatusChange(row){
      let req  = {'id':row.id,'showStatus':row.showStatus}
      updateCategory(req).then(response => {
        this.$modal.msgSuccess("修改成功");
        this.getList();
      });
    },
    handerChildrenClick(row){
      this.$router.push({ path: "/info/category", query: {parentId:row.id} });
    }
  },
  filters:{
    disableNextLevel(value) {
        if (value === 0) {
          return false;
        } else {
          return true;
        }
      }
  }
};
</script>

<style lang="scss" scoped>
.box-card{
  box-shadow: none;
}
.box-table{
  margin-top: 20px;
}
.card-icon{
  padding: 0 3px;
}
</style>
