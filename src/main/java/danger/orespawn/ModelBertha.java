/*     */ package danger.orespawn;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelBertha
/*     */   extends ModelBase
/*     */ {
/*     */   ModelRenderer Grip;
/*     */   ModelRenderer Blade;
/*     */   ModelRenderer Handguard2;
/*     */   ModelRenderer Handguard1;
/*     */   ModelRenderer hg2;
/*     */   ModelRenderer hg4;
/*     */   ModelRenderer hg3;
/*     */   ModelRenderer hg1;
/*     */   ModelRenderer BaseGrip;
/*     */   ModelRenderer Tip1;
/*     */   ModelRenderer Tip2;
/*     */   ModelRenderer Bottom;
/*     */   
/*     */   public ModelBertha() {
/*  26 */     this.textureWidth = 64;
/*  27 */     this.textureHeight = 128;
/*     */     
/*  29 */     this.Grip = new ModelRenderer(this, 0, 0);
/*  30 */     this.Grip.addBox(0.0F, -6.0F, 0.0F, 1, 12, 1);
/*  31 */     this.Grip.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  32 */     this.Grip.setTextureSize(64, 128);
/*  33 */     this.Grip.mirror = true;
/*  34 */     setRotation(this.Grip, 0.0F, 0.0F, 0.0F);
/*  35 */     this.Blade = new ModelRenderer(this, 6, 0);
/*  36 */     this.Blade.addBox(0.0F, -41.0F, -1.0F, 1, 34, 3);
/*  37 */     this.Blade.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  38 */     this.Blade.setTextureSize(64, 128);
/*  39 */     this.Blade.mirror = true;
/*  40 */     setRotation(this.Blade, 0.0F, 0.0F, 0.0F);
/*  41 */     this.Handguard2 = new ModelRenderer(this, 16, 0);
/*  42 */     this.Handguard2.addBox(0.0F, -7.0F, -4.0F, 1, 1, 9);
/*  43 */     this.Handguard2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  44 */     this.Handguard2.setTextureSize(64, 128);
/*  45 */     this.Handguard2.mirror = true;
/*  46 */     setRotation(this.Handguard2, 0.0F, 0.0F, 0.0F);
/*  47 */     this.Handguard1 = new ModelRenderer(this, 18, 12);
/*  48 */     this.Handguard1.addBox(-3.0F, -7.0F, 0.0F, 7, 1, 1);
/*  49 */     this.Handguard1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  50 */     this.Handguard1.setTextureSize(64, 128);
/*  51 */     this.Handguard1.mirror = true;
/*  52 */     setRotation(this.Handguard1, 0.0F, 0.0F, 0.0F);
/*  53 */     this.hg2 = new ModelRenderer(this, 0, 15);
/*  54 */     this.hg2.addBox(0.0F, -8.0F, -5.0F, 1, 1, 1);
/*  55 */     this.hg2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  56 */     this.hg2.setTextureSize(64, 128);
/*  57 */     this.hg2.mirror = true;
/*  58 */     setRotation(this.hg2, 0.0F, 0.0F, 0.0F);
/*  59 */     this.hg4 = new ModelRenderer(this, 0, 18);
/*  60 */     this.hg4.addBox(0.0F, -8.0F, 5.0F, 1, 1, 1);
/*  61 */     this.hg4.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  62 */     this.hg4.setTextureSize(64, 128);
/*  63 */     this.hg4.mirror = true;
/*  64 */     setRotation(this.hg4, 0.0F, 0.0F, 0.0F);
/*  65 */     this.hg3 = new ModelRenderer(this, 0, 21);
/*  66 */     this.hg3.addBox(-4.0F, -8.0F, 0.0F, 1, 1, 1);
/*  67 */     this.hg3.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  68 */     this.hg3.setTextureSize(64, 128);
/*  69 */     this.hg3.mirror = true;
/*  70 */     setRotation(this.hg3, 0.0F, 0.0F, 0.0F);
/*  71 */     this.hg1 = new ModelRenderer(this, 0, 24);
/*  72 */     this.hg1.addBox(4.0F, -8.0F, 0.0F, 1, 1, 1);
/*  73 */     this.hg1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  74 */     this.hg1.setTextureSize(64, 128);
/*  75 */     this.hg1.mirror = true;
/*  76 */     setRotation(this.hg1, 0.0F, 0.0F, 0.0F);
/*  77 */     this.BaseGrip = new ModelRenderer(this, 0, 39);
/*  78 */     this.BaseGrip.addBox(-1.0F, 5.0F, -1.0F, 3, 1, 3);
/*  79 */     this.BaseGrip.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  80 */     this.BaseGrip.setTextureSize(64, 128);
/*  81 */     this.BaseGrip.mirror = true;
/*  82 */     setRotation(this.BaseGrip, 0.0F, 0.0F, 0.0F);
/*  83 */     this.Tip1 = new ModelRenderer(this, 21, 16);
/*  84 */     this.Tip1.addBox(0.0F, -42.0F, -0.5F, 1, 1, 2);
/*  85 */     this.Tip1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  86 */     this.Tip1.setTextureSize(64, 128);
/*  87 */     this.Tip1.mirror = true;
/*  88 */     setRotation(this.Tip1, 0.0F, 0.0F, 0.0F);
/*  89 */     this.Tip2 = new ModelRenderer(this, 22, 20);
/*  90 */     this.Tip2.addBox(0.0F, -43.0F, 0.0F, 1, 1, 1);
/*  91 */     this.Tip2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  92 */     this.Tip2.setTextureSize(64, 128);
/*  93 */     this.Tip2.mirror = true;
/*  94 */     setRotation(this.Tip2, 0.0F, 0.0F, 0.0F);
/*  95 */     this.Bottom = new ModelRenderer(this, 0, 45);
/*  96 */     this.Bottom.addBox(0.0F, 6.0F, 0.0F, 1, 1, 1);
/*  97 */     this.Bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  98 */     this.Bottom.setTextureSize(64, 128);
/*  99 */     this.Bottom.mirror = true;
/* 100 */     setRotation(this.Bottom, 0.0F, 0.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render() {
/* 105 */     float f5 = 1.0F;
/*     */     
/* 107 */     this.Grip.render(f5);
/* 108 */     this.Blade.render(f5);
/* 109 */     this.Handguard2.render(f5);
/* 110 */     this.Handguard1.render(f5);
/* 111 */     this.hg2.render(f5);
/* 112 */     this.hg4.render(f5);
/* 113 */     this.hg3.render(f5);
/* 114 */     this.hg1.render(f5);
/* 115 */     this.BaseGrip.render(f5);
/* 116 */     this.Tip1.render(f5);
/* 117 */     this.Tip2.render(f5);
/* 118 */     this.Bottom.render(f5);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 123 */     model.rotateAngleX = x;
/* 124 */     model.rotateAngleY = y;
/* 125 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ModelBertha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */