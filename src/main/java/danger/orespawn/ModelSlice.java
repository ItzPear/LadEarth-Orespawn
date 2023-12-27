/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSlice
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Grip;
/*     */   ModelRenderer Blade1;
/*     */   ModelRenderer Handguard2;
/*     */   ModelRenderer Handguard1;
/*     */   ModelRenderer hg2;
/*     */   ModelRenderer hg4;
/*     */   ModelRenderer hg3;
/*     */   ModelRenderer hg1;
/*     */   ModelRenderer BaseGrip;
/*     */   ModelRenderer Bottom;
/*     */   ModelRenderer Blade2;
/*     */   ModelRenderer Blade3;
/*     */   ModelRenderer Blade4;
/*     */   ModelRenderer Shape1;
/*     */   
/*     */   public ModelSlice() {
/*  28 */     this.textureWidth = 64;
/*  29 */     this.textureHeight = 128;
/*     */     
/*  31 */     this.Grip = new ModelRenderer(this, 0, 0);
/*  32 */     this.Grip.addBox(0.0F, -6.0F, 0.0F, 1, 12, 1);
/*  33 */     this.Grip.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  34 */     this.Grip.setTextureSize(64, 128);
/*  35 */     this.Grip.mirror = true;
/*  36 */     setRotation(this.Grip, 0.0F, 0.0F, 0.0F);
/*  37 */     this.Blade1 = new ModelRenderer(this, 6, 49);
/*  38 */     this.Blade1.addBox(0.0F, -41.0F, 0.0F, 1, 34, 3);
/*  39 */     this.Blade1.setRotationPoint(0.5F, 0.0F, -2.3F);
/*  40 */     this.Blade1.setTextureSize(64, 128);
/*  41 */     this.Blade1.mirror = true;
/*  42 */     setRotation(this.Blade1, 0.0F, 0.3490659F, 0.0F);
/*  43 */     this.Handguard2 = new ModelRenderer(this, 16, 0);
/*  44 */     this.Handguard2.addBox(0.0F, -7.0F, -4.0F, 1, 1, 9);
/*  45 */     this.Handguard2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  46 */     this.Handguard2.setTextureSize(64, 128);
/*  47 */     this.Handguard2.mirror = true;
/*  48 */     setRotation(this.Handguard2, 0.0F, 0.0F, 0.0F);
/*  49 */     this.Handguard1 = new ModelRenderer(this, 18, 12);
/*  50 */     this.Handguard1.addBox(-3.0F, -7.0F, 0.0F, 7, 1, 1);
/*  51 */     this.Handguard1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  52 */     this.Handguard1.setTextureSize(64, 128);
/*  53 */     this.Handguard1.mirror = true;
/*  54 */     setRotation(this.Handguard1, 0.0F, 0.0F, 0.0F);
/*  55 */     this.hg2 = new ModelRenderer(this, 0, 15);
/*  56 */     this.hg2.addBox(0.0F, -9.0F, -7.0F, 1, 3, 3);
/*  57 */     this.hg2.setRotationPoint(0.5F, 0.0F, 0.0F);
/*  58 */     this.hg2.setTextureSize(64, 128);
/*  59 */     this.hg2.mirror = true;
/*  60 */     setRotation(this.hg2, 0.0F, 0.0F, 0.0F);
/*  61 */     this.hg4 = new ModelRenderer(this, 0, 22);
/*  62 */     this.hg4.addBox(0.0F, -9.0F, 5.0F, 1, 3, 3);
/*  63 */     this.hg4.setRotationPoint(0.5F, 0.0F, 0.0F);
/*  64 */     this.hg4.setTextureSize(64, 128);
/*  65 */     this.hg4.mirror = true;
/*  66 */     setRotation(this.hg4, 0.0F, 0.0F, 0.0F);
/*  67 */     this.hg3 = new ModelRenderer(this, 0, 29);
/*  68 */     this.hg3.addBox(-4.0F, -9.0F, 0.0F, 3, 3, 1);
/*  69 */     this.hg3.setRotationPoint(-2.0F, 0.0F, 0.5F);
/*  70 */     this.hg3.setTextureSize(64, 128);
/*  71 */     this.hg3.mirror = true;
/*  72 */     setRotation(this.hg3, 0.0F, 0.0F, 0.0F);
/*  73 */     this.hg1 = new ModelRenderer(this, 0, 34);
/*  74 */     this.hg1.addBox(4.0F, -9.0F, 0.0F, 3, 3, 1);
/*  75 */     this.hg1.setRotationPoint(0.0F, 0.0F, 0.5F);
/*  76 */     this.hg1.setTextureSize(64, 128);
/*  77 */     this.hg1.mirror = true;
/*  78 */     setRotation(this.hg1, 0.0F, 0.0F, 0.0F);
/*  79 */     this.BaseGrip = new ModelRenderer(this, 0, 39);
/*  80 */     this.BaseGrip.addBox(-1.0F, 5.0F, -1.0F, 3, 1, 3);
/*  81 */     this.BaseGrip.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  82 */     this.BaseGrip.setTextureSize(64, 128);
/*  83 */     this.BaseGrip.mirror = true;
/*  84 */     setRotation(this.BaseGrip, 0.0F, 0.0F, 0.0F);
/*  85 */     this.Bottom = new ModelRenderer(this, 0, 45);
/*  86 */     this.Bottom.addBox(0.0F, 6.0F, 0.0F, 1, 1, 1);
/*  87 */     this.Bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  88 */     this.Bottom.setTextureSize(64, 128);
/*  89 */     this.Bottom.mirror = true;
/*  90 */     setRotation(this.Bottom, 0.0F, 0.0F, 0.0F);
/*  91 */     this.Blade2 = new ModelRenderer(this, 24, 49);
/*  92 */     this.Blade2.addBox(-1.0F, -41.0F, 0.0F, 1, 34, 3);
/*  93 */     this.Blade2.setRotationPoint(0.5F, 0.0F, -2.3F);
/*  94 */     this.Blade2.setTextureSize(64, 128);
/*  95 */     this.Blade2.mirror = true;
/*  96 */     setRotation(this.Blade2, 0.0F, -0.3490659F, 0.0F);
/*  97 */     this.Blade3 = new ModelRenderer(this, 15, 49);
/*  98 */     this.Blade3.addBox(0.0F, -41.0F, 0.0F, 1, 34, 3);
/*  99 */     this.Blade3.setRotationPoint(1.5F, 0.0F, 0.4F);
/* 100 */     this.Blade3.setTextureSize(64, 128);
/* 101 */     this.Blade3.mirror = true;
/* 102 */     setRotation(this.Blade3, 0.0F, -0.3490659F, 0.0F);
/* 103 */     this.Blade4 = new ModelRenderer(this, 33, 49);
/* 104 */     this.Blade4.addBox(0.0F, -41.0F, 0.0F, 1, 34, 3);
/* 105 */     this.Blade4.setRotationPoint(-1.5F, 0.0F, 0.7F);
/* 106 */     this.Blade4.setTextureSize(64, 128);
/* 107 */     this.Blade4.mirror = true;
/* 108 */     setRotation(this.Blade4, 0.0F, 0.3490659F, 0.0F);
/* 109 */     this.Shape1 = new ModelRenderer(this, 6, 0);
/* 110 */     this.Shape1.addBox(0.0F, -6.0F, 0.0F, 1, 6, 3);
/* 111 */     this.Shape1.setRotationPoint(0.5F, -40.0F, -1.0F);
/* 112 */     this.Shape1.setTextureSize(64, 128);
/* 113 */     this.Shape1.mirror = true;
/* 114 */     setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 119 */     float f5 = 1.0F;
/*     */     
/* 121 */     this.Grip.render(f5);
/* 122 */     this.Blade1.render(f5);
/* 123 */     this.Handguard2.render(f5);
/* 124 */     this.Handguard1.render(f5);
/* 125 */     this.hg2.render(f5);
/* 126 */     this.hg4.render(f5);
/* 127 */     this.hg3.render(f5);
/* 128 */     this.hg1.render(f5);
/* 129 */     this.BaseGrip.render(f5);
/* 130 */     this.Bottom.render(f5);
/* 131 */     this.Blade2.render(f5);
/* 132 */     this.Blade3.render(f5);
/* 133 */     this.Blade4.render(f5);
/* 134 */     this.Shape1.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 139 */     model.rotateAngleX = x;
/* 140 */     model.rotateAngleY = y;
/* 141 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelSlice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */